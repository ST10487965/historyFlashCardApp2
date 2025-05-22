package vcmsa.ci.historyflashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CardFlash : AppCompatActivity() {

// List of questions nd their answers (true/false)
    private val questions = arrayOf(
        "Nelson Mandela became president in 1994.", // true
        "The Berlin Wall fell in 1991.", // false (actually in 1989)
        "World War II ended in 1945.", // true
        "The Great Depression began in 1929.", // true
        "The first moon landing was in 1969." // true
    )

    private val answers = arrayOf(true, false, true, true, true)

    // Keep track of where we are and the score
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_flash)

        // Connect to the buttons/ TextViews in our layout
        val questionTextView = findViewById<TextView>(R.id.questionTextView)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        // Show first question when starting
        questionTextView.text = questions[currentQuestionIndex]

        // What happens when user answers
        fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = answers[currentQuestionIndex]
            if (userAnswer == correctAnswer) {
                feedbackTextView.text = "Correct!" // add 1 to score if right
                score++
            } else {
                feedbackTextView.text = "Incorrect!"
            }
        }

        // button click actions :
        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentQuestionIndex++ // move to next question
            if (currentQuestionIndex < questions.size) { // show next question
                questionTextView.text = questions[currentQuestionIndex]
                feedbackTextView.text = "" // clear feedback
            } else {
                // no more questions, go to results screen
                val intent = Intent(this, screenResult::class.java)
                intent.putExtra("score", score) // snd final score
                startActivity(intent)
                finish() // close this screen
            }
        }
    }
}
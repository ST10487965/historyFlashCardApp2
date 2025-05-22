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


    private val questions = arrayOf(
        "Nelson Mandela became president in 1994.",
        "The Berlin Wall fell in 1991.",
        "World War II ended in 1945.",
        "The Great Depression began in 1929.",
        "The first moon landing was in 1969."
    )

    private val answers = arrayOf(true, false, true, true, true)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_flash)

        val questionTextView = findViewById<TextView>(R.id.questionTextView)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        questionTextView.text = questions[currentQuestionIndex]

        fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = answers[currentQuestionIndex]
            if (userAnswer == correctAnswer) {
                feedbackTextView.text = "Correct!"
                score++
            } else {
                feedbackTextView.text = "Incorrect!"
            }
        }

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                questionTextView.text = questions[currentQuestionIndex]
                feedbackTextView.text = ""
            } else {
                val intent = Intent(this, screenResult::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
    }
}
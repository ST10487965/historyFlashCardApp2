package vcmsa.ci.historyflashcardapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class screenResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_result)


        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val feedbackTextView = findViewById<TextView>(R.id.textView3)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.button2)


        val correctAnswers = intent.getIntExtra("correctAnswers", 4)
        val totalQuestions = intent.getIntExtra("totalQuestions", 5)


        scoreTextView.text = "Your score: $correctAnswers/$totalQuestions"


        val feedback = when {
            correctAnswers == totalQuestions -> "Perfect! You got all answers right!"
            correctAnswers > totalQuestions / 2 -> "Good job! You passed!"
            else -> "Keep practicing! You can do better!"
        }
        feedbackTextView.text = "Feedback: $feedback"


        reviewButton.setOnClickListener {

        }

        exitButton.setOnClickListener {

            finish()


        }
    }
}
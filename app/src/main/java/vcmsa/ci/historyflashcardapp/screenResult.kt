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

        // Get references to views
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val feedbackTextView = findViewById<TextView>(R.id.textView3)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.button2)

        // Get score data from intent (example)
        val correctAnswers = intent.getIntExtra("correctAnswers", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 5)

        // Update score text
        scoreTextView.text = "Your score: $correctAnswers/$totalQuestions"

        // Set feedback based on score
        val feedback = when {
            correctAnswers == totalQuestions -> "Perfect! You got all answers right!"
            correctAnswers > totalQuestions / 2 -> "Good job! You passed!"
            else -> "Keep practicing! You can do better!"
        }
        feedbackTextView.text = "Feedback: $feedback"

        // Set click listeners
        reviewButton.setOnClickListener {
            // Add your review answers logic here
            // For example: startActivity(Intent(this, ReviewActivity::class.java))
        }

        exitButton.setOnClickListener {
            // Finish this activity and return to previous
            finish()

            // Or if you want to exit the app completely:
            // finishAffinity()
        }
    }
}
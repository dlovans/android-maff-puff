package dev.dlovan.maffpuff

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.dlovan.maffpuff.databinding.ActivityMathBinding

class MathActivity : AppCompatActivity() {
    lateinit var binding: ActivityMathBinding
    lateinit var mathType: String
    var correctAnswer: Double = 0.0
    var answer: Double = 0.0
    var correctCalc: Int = 0
    var incorrectCalc: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mathType = intent.extras?.getString("operation") ?: "addition"
        this.setOperation(mathType)

        binding.submitAnswer.setOnClickListener {
            answer = binding.answerInput.text.toString().toDouble()
            if (answer == correctAnswer) {
                correctCalc++
                val correctText = "Correct: $correctCalc"
                binding.correctScore.text = correctText
            } else {
                incorrectCalc++
                val incorrectText = "Incorrect: $incorrectCalc"
                binding.incorrectScore.text = incorrectText
            }

            binding.answerInput.text?.clear()
            this.setOperation(mathType)
        }

        binding.changeMath.setOnClickListener {
            finish()
        }
    }

    fun setOperation(operation: String) {
        val firstNumber = (1..100).random()
        val secondNumber = (1..100).random()
        val mathSign: String

        when (operation) {
            "addition" -> mathSign = "+"
            "subtraction" -> mathSign = "-"
            "multiplication" -> mathSign = "*"
            "division" -> mathSign = "/"
            else -> mathSign = "+"
        }

        when (operation) {
            "addition" -> correctAnswer = (firstNumber + secondNumber).toDouble()
            "subtraction" -> correctAnswer = (firstNumber - secondNumber).toDouble()
            "multiplication" -> correctAnswer = (firstNumber * secondNumber).toDouble()
            "division" -> correctAnswer = (firstNumber / secondNumber).toDouble()

        }

        val question = "$firstNumber $mathSign $secondNumber = "
        binding.mathQuestion.text = question
    }
}
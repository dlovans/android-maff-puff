package dev.dlovan.maffpuff

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.dlovan.maffpuff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAddition.setOnClickListener {
            val newIntent = Intent(this, MathActivity::class.java)
            newIntent.putExtra("operation", "addition")
        }
        binding.btnSubtraction.setOnClickListener {
            val newIntent = Intent(this, MathActivity::class.java)
            newIntent.putExtra("operation", "subtraction")
        }
        binding.btnMultiplication.setOnClickListener {
            val newIntent = Intent(this, MathActivity::class.java)
            newIntent.putExtra("operation", "multiplication")
        }
        binding.btnDivision.setOnClickListener {
            val newIntent = Intent(this, MathActivity::class.java)
            newIntent.putExtra("operation", "division")
        }

    }
}
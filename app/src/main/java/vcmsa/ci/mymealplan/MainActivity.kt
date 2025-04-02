package vcmsa.ci.mymealplan

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtTime = findViewById<EditText>(R.id.edtTimeText)
        val txtSuggestMeal = findViewById<TextView>(R.id.txtViewMeals)
        val btnPrepareMeal = findViewById<Button>(R.id.btnPrep)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnPrepareMeal.setOnClickListener { //Button that allows app to prepare the meal suggestion

            val EnterTimeOfDay = edtTime.text.toString().trim().lowercase() // allows for app to use lowercase and uppercase responses

            val mealSuggestion: String
            //declarations of options

            if (EnterTimeOfDay == "morning") {
                mealSuggestion = "Breakfast: Have toast,eggs,mushrooms,bacon, pancakes and tea or water. Consider brown bread or white based on diet."
            } else if (EnterTimeOfDay == "mid morning") {
                mealSuggestion = "Morning Snack: Smoothie, Fruits, Yoghurt, Water"
            } else if (EnterTimeOfDay == "afternoon") {
                mealSuggestion = "Lunch: Sandwich- with either jam,peanut butter,ham and cheese. Consider a hot-dog, pizza, burger with fries."
            } else if (EnterTimeOfDay == "afternoon snack") {
                mealSuggestion = "Snack: Bag of chips, peanuts, fruits,snack bar,cool drink, smoothie and avocado dip."
            } else if (EnterTimeOfDay=="dinner") {
                mealSuggestion = "Dinner: Rice or Pap,Meat,Beans,vegetables. Pasta with mines and paste sauce of your choice. Potato mash with grave, steak and vegetables"
            } else if (EnterTimeOfDay=="after dinner snack") {
                mealSuggestion = "Desserts: Ice-cream,Yogurts,Cookies,Cake and Milk shake"
            } else {
                mealSuggestion = "Invalid Input- Please enter ( morning, mis-morning, afternoon, afternoon snack, dinner, after dinner snack)."
            }
            txtSuggestMeal.text= mealSuggestion

        }

        btnReset.setOnClickListener { //Button that clears all user response

            edtTime.text.clear() //clear the users response
        }

































        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
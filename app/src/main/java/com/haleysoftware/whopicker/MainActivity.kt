package com.haleysoftware.whopicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var whatSpin: Spinner

    private lateinit var whoSpin: Spinner

    private lateinit var whoAdapter: ArrayAdapter<CharSequence>

    var whatText = "Anything"
    var whoText = "Any"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        whatSpin = findViewById(R.id.spinWhat)
        val whatAdapter = ArrayAdapter.createFromResource(this, R.array.spin_select, android.R.layout.simple_spinner_item)
        whatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        whatSpin.adapter = whatAdapter
        whatSpin.onItemSelectedListener = this

        whoSpin = findViewById(R.id.spinWho)
        whoAdapter = ArrayAdapter.createFromResource(this, R.array.spin_any, android.R.layout.simple_spinner_item)
        whoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        whoSpin.adapter = whoAdapter
        whoSpin.isEnabled = false
        whoSpin.onItemSelectedListener = this

        findViewById<Button>(R.id.bPick).setOnClickListener {
            Toast.makeText(this, "What = $whatText. Who = $whoText.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //Do Nothing
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        when (parent){
            whatSpin -> {
                whatText = parent.getItemAtPosition(pos).toString()
                whoSpin.isEnabled = pos != 0
                whoAdapter = when(pos){
                    0 -> ArrayAdapter.createFromResource(this, R.array.spin_any, android.R.layout.simple_spinner_item)
                    1 -> ArrayAdapter.createFromResource(this, R.array.spin_season, android.R.layout.simple_spinner_item)
                    2 -> ArrayAdapter.createFromResource(this, R.array.spin_special, android.R.layout.simple_spinner_item)
                    3 -> ArrayAdapter.createFromResource(this, R.array.spin_doctor, android.R.layout.simple_spinner_item)
                    4 -> ArrayAdapter.createFromResource(this, R.array.spin_enemy, android.R.layout.simple_spinner_item)
                    5 -> ArrayAdapter.createFromResource(this, R.array.spin_mood, android.R.layout.simple_spinner_item)
                    else -> ArrayAdapter.createFromResource(this, R.array.spin_error, android.R.layout.simple_spinner_item)
                }
                findViewById<TextView>(R.id.textWho).text = when(pos){
                    0 -> resources.getString(R.string.pickAll)
                    1 -> resources.getString(R.string.pickSeason)
                    2 -> resources.getString(R.string.pickSpecial)
                    3 -> resources.getString(R.string.pickDoctor)
                    4 -> resources.getString(R.string.pickEnemy)
                    5 -> resources.getString(R.string.pickMood)
                    else -> resources.getString(R.string.pickError)
                }
                whoSpin.adapter = whoAdapter
                //TODO Might need to set whoText
            }
            whoSpin -> whoText = parent.getItemAtPosition(pos).toString()

        }
    }
}

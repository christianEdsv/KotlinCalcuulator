package com.example.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.example.helloword.logica.Calculos

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val operaciones = Calculos()
    var opcion : String = ""
    lateinit var numero1: EditText
    lateinit var numero2: EditText
    lateinit var resultado : TextView
    lateinit var spinner: Spinner
    lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numero1 = findViewById(R.id.edtN1)
        numero2 = findViewById(R.id.edtN2)
        resultado = findViewById(R.id.tvResultado)
        spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.operaciones,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            spinner.onItemSelectedListener = this
        }

        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {

            if(TextUtils.isEmpty(numero1.text)){
                numero1.setError( "Numero requerido!" );
            }
            else if(TextUtils.isEmpty(numero2.text)){
                numero2.setError( "Numero requerido!" );
            }
            else {
                when {
                    (opcion.equals("Suma")) ->{
                        val operacion = operaciones.Suma(numero1.text.toString().toFloat(), numero2.text.toString().toFloat()).toString()

                        resultado.text = ("Resultado: $operacion")
                    }
                    (opcion.equals("Resta")) ->{
                        val operacion = operaciones.Resta(numero1.text.toString().toFloat(), numero2.text.toString().toFloat()).toString()

                        resultado.text = ("Resultado: $operacion")
                    }
                    (opcion.equals("Multiplicacion")) ->{
                        val operacion = operaciones.Multiplicacion(numero1.text.toString().toFloat(), numero2.text.toString().toFloat()).toString()

                        resultado.text = ("Resultado: $operacion")
                    }
                    (opcion.equals("Division")) ->{
                        val operacion = operaciones.Division(numero1.text.toString().toFloat(), numero2.text.toString().toFloat()).toString()

                        resultado.text = ("Resultado: $operacion")
                    }
                    else -> Toast.makeText(this, "No existe: $opcion", Toast.LENGTH_LONG).show()
                }

                numero1.setText("")
                numero2.setText("")
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        opcion = parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}
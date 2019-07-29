package com.example.resistorcalculation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var multiplicidad1 = 0
    private var multiplicidad2 = 0
    private var multiplicidad3 = 0
    private var tolerancia = 5
    private var resultado = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaColores = arrayOf("Negro", "Marrón", "Rojo", "Naranja","Amarillo","Verde","Azul","Violeta","Gris","Blanco")
        val listaTolerancia = arrayOf("Dorado","Plateado","Marrón","Rojo")
        spnBarraUno.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaColores)
        spnBarraDos.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaColores)
        spnBarraTres.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaColores)
        spnBarraCuatro.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaTolerancia)

        spnBarraUno.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                tvBarra1.text = "Elige una opción"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tvBarra1.text = listaColores[p2]
                multiplicidad1 = p2
                when(spnBarraUno.selectedItem.toString()) {
                    "Negro" -> tvBarraUno.setBackgroundColor(Color.BLACK)
                    "Marrón" -> tvBarraUno.setBackgroundColor(Color.rgb(120,66,18))
                    "Rojo" -> tvBarraUno.setBackgroundColor(Color.RED)
                    "Naranja" -> tvBarraUno.setBackgroundColor(Color.rgb(211,84,0))
                    "Amarillo" -> tvBarraUno.setBackgroundColor(Color.YELLOW)
                    "Verde" -> tvBarraUno.setBackgroundColor(Color.rgb(20,90,60))
                    "Azul" -> tvBarraUno.setBackgroundColor(Color.BLUE)
                    "Violeta" -> tvBarraUno.setBackgroundColor(Color.MAGENTA)
                    "Blanco" -> tvBarraUno.setBackgroundColor(Color.WHITE)
                    "Gris" -> tvBarraUno.setBackgroundColor(Color.GRAY)
                }
            }

        }
        spnBarraDos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                tvBarra2.text = "Elige una opción"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tvBarra2.text = listaColores[p2]
                multiplicidad2 = p2
                when (spnBarraDos.selectedItem.toString()) {
                    "Negro" -> tvBarraDos.setBackgroundColor(Color.BLACK)
                    "Marrón" -> tvBarraDos.setBackgroundColor(Color.rgb(120, 66, 18))
                    "Rojo" -> tvBarraDos.setBackgroundColor(Color.RED)
                    "Naranja" -> tvBarraDos.setBackgroundColor(Color.rgb(211, 84, 0))
                    "Amarillo" -> tvBarraDos.setBackgroundColor(Color.YELLOW)
                    "Verde" -> tvBarraDos.setBackgroundColor(Color.rgb(20, 90, 60))
                    "Azul" -> tvBarraDos.setBackgroundColor(Color.BLUE)
                    "Violeta" -> tvBarraDos.setBackgroundColor(Color.MAGENTA)
                    "Blanco" -> tvBarraDos.setBackgroundColor(Color.WHITE)
                    "Gris" -> tvBarraDos.setBackgroundColor(Color.GRAY)
                }
            }
        }
        spnBarraTres.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                    tvBarra3.text = "Elige una opción"
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tvBarra3.text = listaColores[p2]
                multiplicidad3 = p2
                when(spnBarraTres.selectedItem.toString()) {
                    "Negro" -> tvBarraTres.setBackgroundColor(Color.BLACK)
                    "Marrón" -> tvBarraTres.setBackgroundColor(Color.rgb(120,66,18))
                    "Rojo" -> tvBarraTres.setBackgroundColor(Color.RED)
                    "Naranja" -> tvBarraTres.setBackgroundColor(Color.rgb(211,84,0))
                    "Amarillo" -> tvBarraTres.setBackgroundColor(Color.YELLOW)
                    "Verde" -> tvBarraTres.setBackgroundColor(Color.rgb(20,90,60))
                    "Azul" -> tvBarraTres.setBackgroundColor(Color.BLUE)
                    "Violeta" -> tvBarraTres.setBackgroundColor(Color.MAGENTA)
                    "Blanco" -> tvBarraTres.setBackgroundColor(Color.WHITE)
                    "Gris" -> tvBarraTres.setBackgroundColor(Color.GRAY)
                }
            }

        }
        spnBarraCuatro.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                tvBarra4.text = "Elige una opción"
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tvBarra4.text = listaTolerancia[p2]
                when(spnBarraCuatro.selectedItem.toString()) {
                    "Dorado"->{
                        tvBarraCuatro.setBackgroundColor(Color.rgb(212, 172, 13))
                        tolerancia = 5
                    }
                    "Plateado" -> {
                        tvBarraCuatro.setBackgroundColor(Color.rgb(179, 182, 183))
                        tolerancia = 10
                    }
                    "Marrón" -> {
                        tvBarraCuatro.setBackgroundColor(Color.rgb(120,66,18))
                        tolerancia = 1
                    }
                    "Rojo" -> {
                        tvBarraCuatro.setBackgroundColor(Color.RED)
                        tolerancia = 2
                    }
                }
            }

        }
        bnCalcular.setOnClickListener {
            var potencia = ""
            for(i in 0..multiplicidad3){
                if(i==0)
                    potencia = ""
                else
                    potencia +="0"
            }
            /*resultado = (((multiplicidad1 * 10) + multiplicidad2) * potencia).toLong()
            if(resultado >0 && resultado<1000)
                tvResultado.text = resultado.toString() + " Ω"+" ±" +" ${tolerancia}%"*/
            resultado = ("$multiplicidad1"+"$multiplicidad2"+potencia).toDouble()
            if(multiplicidad3<3)
                tvResultado.text = (resultado).toInt().toString()+" Ω"+" ±" +" ${tolerancia}%"
            else
                if(multiplicidad3>=3 && multiplicidad3 < 6)
                    tvResultado.text = (resultado/1000).toInt().toString()+" KΩ"+" ±" +" ${tolerancia}%"
                else
                    if(multiplicidad3>=6 && multiplicidad3 < 9)
                        tvResultado.text = (resultado/1000000).toInt().toString()+" MΩ"+" ±" +" ${tolerancia}%"
                    else
                        tvResultado.text = (resultado/1000000000).toInt().toString()+" GΩ"+" ±" +" ${tolerancia}%"


        }

    }
    override fun onClick(p0: View?) {

    }
}


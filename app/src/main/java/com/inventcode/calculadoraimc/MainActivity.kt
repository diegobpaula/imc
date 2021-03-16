package com.inventcode.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imc()
        clearInput()
    }

    fun imc(){
        btn_calcular.setOnClickListener {

            if (input_idade.text.isEmpty() || input_altura.text.isEmpty() || input_peso.text.isEmpty()){
                Toast.makeText(this, "Campos vazios",Toast.LENGTH_LONG).show()
            }else{
                val altura: Float = (input_altura.text.toString()).toFloat()
                val peso: Float = (input_peso.text.toString()).toFloat()
                val imc = calc_imc(peso, altura)
                interpretation(imc)
               // selecionaSexo()

            }
        }
    }

    fun calc_imc(peso:Float, altura:Float):Float {
        val imc = peso / (altura * altura)
        return imc
    }


    fun selecionaSexo(){
        val masculino = rb_sexo_masculino
        val feminino = rb_sexo_femino

        if(masculino.isChecked()){
            txt_resultado.setText("MASCULINO")
        }else if (feminino.isChecked()){
            txt_resultado.setText("FEMININO")
        }
    }

    fun interpretation(imc:Float){
        val idade: Int = input_idade.text.toString().toInt()

        if (imc >= 40) {
                txt_resultado.setText("Idade: $idade\nIMC: $imc\nClassificação: OBESIDADE GRAVE\nGRAU: III\n")
            } else if (imc >= 30.0 && imc <= 39.9) {
                txt_resultado.setText("IMC: $imc\nClassificação: OBESIDADE\nGRAU: II")
            } else if (imc >= 25.0 && imc <= 29.9) {
                txt_resultado.setText("IMC: $imc\nClassificação: SOBREPESO\nGRAU: I")
            } else if (imc >= 18.5 && imc <= 24.9) {
                txt_resultado.setText("IMC: $imc\nClassificação: NORMAL\nGRAU: 0")
            } else {
                txt_resultado.setText("IMC: $imc\nClassificação: MAGREZA\nGRAU: 0")
            }
    }

    fun clearInput(){
       btn_clear.setOnClickListener {
           radioGroupSexo.clearCheck()
           input_idade.setText("")
           input_altura.setText("")
           input_peso.setText("")
           txt_resultado.setText("")
       }
    }

}
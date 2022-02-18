package gt.edu.galileo.ejemploparcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import gt.edu.galileo.ejemploparcial1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (binding.rdMedida.getChildAt(0) as RadioButton).isChecked = true
        binding.btnCalcular.setOnClickListener{
            var resultado = 0f
            var gradosRespuesta = "Celcius"
            if ((binding.rdMedida.getChildAt(0) as RadioButton).isChecked) {
                //Esta seleccionbado Celcius
                resultado = calcularFahrenheit(binding.txtGrados.text.toString().toFloat())
                gradosRespuesta = "Fahrenheit"
            } else {
                //Esta seleccionado Fahrenheit
                resultado = calcularCelcius(binding.txtGrados.text.toString().toFloat())
            }
            binding.txtRespuesta.text = "La respuesta es : " + resultado + " " + gradosRespuesta
        }
    }

    fun calcularCelcius(fahr: Float): Float {
        return (fahr - 32.0f)/1.8f
    }
    fun calcularFahrenheit(cel: Float): Float {
        return cel * 1.8f + 32.0f
    }
}
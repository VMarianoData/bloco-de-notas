package com.example.app_05_anotaes

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.example.app_05_anotaes.AnotacaoPreferencia.AnotacaoPreferencias
import com.example.app_05_anotaes.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var preferencias: AnotacaoPreferencias? = null
    private var editAnotacao: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val editAnotacao = findViewById<EditText>(R.id.blocoAnotacao)
        var  preferencias = AnotacaoPreferencias(applicationContext)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        editAnotacao.setHintTextColor(Color.RED)
        editAnotacao.setTextSize(TypedValue.COMPLEX_UNIT_SP,30f)

        fab.setOnClickListener { view ->
            val textoRecuperado = editAnotacao?.getText().toString()
            if (textoRecuperado =="") {
                Snackbar.make(view, "Digite uma anotação para ser salva", Snackbar.LENGTH_LONG).show()
            } else {
                preferencias!!.salvarAnotacao(textoRecuperado)
                Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show()
            }
            val anotacao = preferencias!!.recuperarAnotacao()
            if (anotacao != "") {
                editAnotacao?.setText(anotacao)
            }
        }
    }
}

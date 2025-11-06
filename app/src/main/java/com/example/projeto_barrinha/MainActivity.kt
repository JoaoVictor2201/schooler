package com.example.projeto_barrinha

import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.projeto_barrinha.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: androidx.navigation.NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        // --- Obter NavController ---
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        navController = navHostFragment.navController

        // --- AppBarConfiguration ---
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.nav_alunos, R.id.nav_detalhes),
            drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Se estivermos em uma tela de autenticação (login/registro)
            if (destination.id == R.id.nav_login || destination.id == R.id.nav_register) {
                // Bloqueia o menu lateral
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                // Esconde o ícone de navegação (seja a seta ou o ícone do menu)
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            } else {
                // Para todas as outras telas, desbloqueia o menu
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                // E garante que o ícone de navegação seja exibido
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }


        // --- Navigation manual para itens do Drawer ---
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.nav_home -> {
                    navController.popBackStack(R.id.nav_home, false)
                    drawerLayout.closeDrawers()
                    true
                }

                R.id.nav_alunos -> {
                    navController.popBackStack(R.id.nav_home, false) // garante voltar para home
                    navController.navigate(R.id.nav_alunos)
                    drawerLayout.closeDrawers()
                    true
                }

                R.id.nav_detalhes -> {
                    navController.popBackStack(R.id.nav_home, false)
                    navController.navigate(R.id.nav_detalhes)
                    drawerLayout.closeDrawers()
                    true
                }

                R.id.nav_logout -> {
                    navController.popBackStack(navController.graph.startDestinationId, true)
                    navController.navigate(R.id.nav_login)
                    drawerLayout.closeDrawers()
                    true
                }

                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun atualizarNomeHeader(nome: String) {
        val headerView = binding.navView.getHeaderView(0)
        val tvNomeMotorista: TextView = headerView.findViewById(R.id.tvNomeMotorista)
        tvNomeMotorista.text = nome
    }
}
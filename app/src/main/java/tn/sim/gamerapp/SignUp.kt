package tn.sim.gamerapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import tn.sim.gamerapp.databinding.SignupBinding

class SignUp : AppCompatActivity()  {

    private lateinit var binding : SignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBackArrowToolBar()
    }

    // Tool Bar Back Arrow START *************************************
    fun initBackArrowToolBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        //use back arrow from drawable
        val upArrow = resources.getDrawable(R.drawable.ic_back_arrow)
        supportActionBar?.setHomeAsUpIndicator(upArrow)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId()==android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    // Tool Bar Back Arrow END ***************************************
}
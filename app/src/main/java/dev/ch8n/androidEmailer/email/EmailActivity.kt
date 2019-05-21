package dev.ch8n.androidEmailer.email

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.ch8n.androidEmailer.R
import dev.ch8n.androidEmailer.service.email.config.Mailer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_email.*
import timber.log.Timber

class EmailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        buttonSend.setOnClickListener {
            Mailer.sendMail(
                "dev.ch8n@gmail.com",
                "test-mail",
                "dummy test from android app"
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        Toast.makeText(this@EmailActivity, "Mail send check e-mail", Toast.LENGTH_SHORT).show()
                    }, {
                        Timber.e(it)
                    }
                )
        }


    }

}

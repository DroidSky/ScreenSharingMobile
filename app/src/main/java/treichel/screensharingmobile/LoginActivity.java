package treichel.screensharingmobile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
    implements OnClickListener{

    private EditText usernameText;
    private EditText passwordText;
    private Button loginButton;
    private String[] usernames = {"BTreichel", "User2"};
    private String[] passwords = {"goodPass", "testPass"};
    private TextView signUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameText = (EditText)
                findViewById(R.id.usernameText);
        passwordText = (EditText)
                findViewById(R.id.passwordText);
        loginButton = (Button)
                findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
        signUpLink = (TextView)
                findViewById(R.id.signUpView);
        signUpLink.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick (View v){
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        Bundle credentials = new Bundle();
        boolean goodCred = false;
        for(int i = 0; i < usernames.length; i++) {
            if ((username.equals(usernames[i])) && (password.equals(passwords[i]))) {
                goodCred = true;
                credentials.putString("username", username);
                credentials.putString("password", password);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtras(credentials);
                startActivity(intent);
            }
        }
        if(goodCred == false){
            Context context = getApplicationContext();
            CharSequence text = "Wrong Username or Password";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
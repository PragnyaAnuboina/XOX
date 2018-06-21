package com.cs17b004.x_o_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player=0;
    int x=0;
    int array[]={2,2,2,2,2,2,2,2,2};
    boolean win=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void abc(View y){
        ImageView view=(ImageView)y;
        String s=view.getTag().toString();
        int i=Integer.parseInt(s);
        if(array[i]==2&&!win)
            if (player == 0) {
                view.setImageResource(R.drawable.x_1);
                player = 1;
                x++;
                array[i]=0;
            }
            else {
                view.setImageResource(R.drawable.o_1);
                player = 0;
                x++;
                array[i]=1;
            }
        else{
            Toast.makeText(getApplicationContext(),"Invalid move",Toast.LENGTH_SHORT).show();
        }
        boolean b1,b2,b3,b4,b5,b6,b7,b8;
        b1=(array[0]==0)&&(array[1]==0)&&(array[2]==0)||(array[0]==1)&&(array[1]==1)&&(array[2]==1);
        b2=(array[3]==0)&&(array[4]==0)&&(array[5]==0)||(array[3]==1)&&(array[4]==1)&&(array[5]==1);
        b3=(array[6]==0)&&(array[7]==0)&&(array[8]==0)||(array[6]==1)&&(array[7]==1)&&(array[8]==1);
        b4=(array[0]==0)&&(array[3]==0)&&(array[6]==0)||(array[0]==1)&&(array[3]==1)&&(array[6]==1);
        b5=(array[1]==0)&&(array[4]==0)&&(array[7]==0)||(array[1]==1)&&(array[4]==1)&&(array[7]==1);
        b6=(array[2]==0)&&(array[5]==0)&&(array[8]==0)||(array[2]==1)&&(array[5]==1)&&(array[8]==1);
        b7=(array[0]==0)&&(array[4]==0)&&(array[8]==0)||(array[0]==1)&&(array[4]==1)&&(array[8]==1);
        b8=(array[2]==0)&&(array[4]==0)&&(array[6]==0)||(array[2]==1)&&(array[4]==1)&&(array[6]==1);
        TextView t=(TextView)findViewById(R.id.textView);
        win=b1||b2||b3||b4||b5||b6||b7||b8;
        if(win){

            if (player==1)
                t.setText("Congratulations X!!,You won");
            if(player==0)
                 t.setText("Congratulations O!!,You won");
            Button b=(Button)findViewById(R.id.button);
            b.setVisibility(View.VISIBLE);
        }else if(x==9) {
            t.setText("DRAW MATCH");
            Button b=(Button)findViewById(R.id.button);
            b.setVisibility(View.VISIBLE);
        }
        }
    public void playagain(View view){
        Intent x=new Intent(MainActivity.this,MainActivity.class);
        startActivity(x);
    }
}

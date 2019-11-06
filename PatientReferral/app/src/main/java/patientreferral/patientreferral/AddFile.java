package patientreferral.patientreferral;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import uk.co.senab.photoview.PhotoViewAttacher;

public class AddFile extends AppCompatActivity {
ImageView imageView;

    FloatingActionButton fab,fab1,fab2,fab3;
    Animation fabOpen, fabClose,rb,rf;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_file);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        int co = intent.getIntExtra("c",0);
        if(co ==1){
            setTitle("Take a new picture");
        }

        imageView = (ImageView) findViewById(R.id.imageView);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);

        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close);
        rf = AnimationUtils.loadAnimation(this,R.anim.rotate_fwd);
        rb=AnimationUtils.loadAnimation(this,R.anim.rotate_bkw);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Toast.makeText(AddFile.this,"Image Saved",Toast.LENGTH_SHORT).show();
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Toast.makeText(AddFile.this,"Image Deleted",Toast.LENGTH_SHORT).show();
                imageView.setImageBitmap(null);
            }
        });

        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
        photoView.update();

    }

    private void animateFab(){
        if(isOpen){
            fab.startAnimation(rf);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab3.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isOpen=false;
        }
        else {
            fab.startAnimation(rb);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab3.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isOpen=true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bm = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bm);
    }
}

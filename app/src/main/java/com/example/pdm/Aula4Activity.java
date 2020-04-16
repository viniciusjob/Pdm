package com.example.pdm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Aula4Activity extends AppCompatActivity {

    private TextView txtNome, txtTelefone;
    private ImageView imageView;
    private final int SELECT_CONTACT = 0;
    private final int START_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula4);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Menu de Opções");

        txtNome = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtTelefone);
        imageView = findViewById(R.id.imageView);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                finishAffinity();
                break;
            default:
                break;
        }
        return true;
    }

    public void contatoClick(View view) {
        Uri uri = Uri.parse("content://com.android.contacts/contacts");
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(intent, SELECT_CONTACT);

    }

    public void webClick(View view) {
        Uri uri = Uri.parse("http://www.unisc.br");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void ligacaoClick(View view) {
        Uri uri = Uri.parse("tel:51998298197");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Não foi concecida a permissão para realizar ligações", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(intent);
    }

    public void maps1Click(View view) {
        Uri uriGeo = Uri.parse("geo:0,0?q=UNISC, Santa+Cruz+do+Sul");
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uriGeo);
        startActivity(intent);
    }

    public void maps2Click(View view) {
        String geo = "geo:-25.443195,-49.280977";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(geo));
        startActivity(intent);
    }

    public void maps3Click(View view) {
        String partida = "-29.6976663, -52.43867749999998";
        String destino = "-29.7176521, -52.42735859999999";
        String url = "http://maps.google.com/maps?f=d&saddr="+partida+"&daddr"+destino+"&hl=pt";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    public void pictureClick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, START_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_CONTACT) {
            if(resultCode == RESULT_OK) {
                Uri uri = data.getData();

                Cursor c = getContentResolver().query(uri, null, null, null, null);
                c.moveToNext();
                int nameCol = c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME);
                int idCol = c.getColumnIndexOrThrow(ContactsContract.Contacts._ID);
                String nome = c.getString(nameCol);
                String id = c.getString(idCol);
                c.close();

                Cursor phone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
                phone.moveToNext();
                String telefone = phone.getString(phone.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                phone.close();

                txtNome.setText(nome);
                txtTelefone.setText(telefone);
            } else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Nenhum contato selecionado. Por favor selecione algum", Toast.LENGTH_SHORT).show();
            }
        } else if(requestCode == START_CAMERA){
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap bitmap = (Bitmap) extras.get("data");
                imageView.setImageBitmap(bitmap);
            } else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Nenhuma foto foi tirada", Toast.LENGTH_SHORT).show();
            }

        }
    }
}

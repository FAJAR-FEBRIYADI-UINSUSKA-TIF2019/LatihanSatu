package com.tugas1.fajarfebriyadi4b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText etKodeBarang, etJumlahBarang;
    public Button btnhitung, btnreset, btnclose;
    public TextView tvNamaBarang, tvHargaBarang, tvTotalHarga, tvDiskon, tvJumlahBayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fajarfebriyadi4b);

        etKodeBarang = findViewById(R.id.etKodeBarang);
        etJumlahBarang = findViewById(R.id.etJumlahBarang);
        btnhitung = findViewById(R.id.btnhitung);
        btnreset = findViewById(R.id.btnreset);
        btnclose = findViewById(R.id.btnclose);
        tvNamaBarang = findViewById(R.id.tvNamaBarang);
        tvHargaBarang = findViewById(R.id.tvHargaBarang);
        tvTotalHarga = findViewById(R.id.tvTotalHarga);
        tvDiskon = findViewById(R.id.tvDiskon);
        tvJumlahBayar =findViewById(R.id.tvJumlahBayar);

        btnhitung.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btnhitung) {
            try {
                String kode = etKodeBarang.getText().toString().trim();
                int disc = Integer.parseInt(kode.substring(3));
                String kod = kode.substring(0, 3);

                String jml = etJumlahBarang.getText().toString().trim();
                int jumlah = Integer.parseInt(jml);

                if (kod.equalsIgnoreCase("and")){
                    tvNamaBarang.setText(String.valueOf("Nama Barang : Android"));
                    tvHargaBarang.setText(String.valueOf(1000000));
                }
                else if (kod.equalsIgnoreCase("ios")){
                    tvNamaBarang.setText(String.valueOf("Nama Barang : Apple"));
                    tvHargaBarang.setText(String.valueOf(2000000));
                }
                else if (kod.equalsIgnoreCase("blb")){
                    tvNamaBarang.setText(String.valueOf("Nama Barang : BlackBerry"));
                    tvHargaBarang.setText(String.valueOf(1750000));
                }
                else if (kod.equalsIgnoreCase("wnp")){
                    tvNamaBarang.setText(String.valueOf("Nama Barang : Windows Phone"));
                    tvHargaBarang.setText(String.valueOf(2500000));
                }

                String harga = tvHargaBarang.getText().toString().trim();
                int h = Integer.parseInt(harga);
                tvHargaBarang.setText("Harga Barang : " + h);
                int total = (jumlah * h);
                tvTotalHarga.setText("Total Harga : " + total);

                String diskon = tvDiskon.getText().toString().trim();
                int d = ((disc * h) / 100) * jumlah;
                tvDiskon.setText("Diskon : " + d);

                String bayar = tvJumlahBayar.getText().toString().trim();
                int p = total - d;
                tvJumlahBayar.setText("Jumlah Bayar : " + p);
            }

            catch (Exception e) {
                if (etKodeBarang.getText().toString().length()==0){
                    etKodeBarang.setError("Silahkan Isi Kode Barang");
                }

                tvNamaBarang.setText("Masukkan Kode Atau Jumlah Barang Yang Benar");
                tvHargaBarang.setText("-");
                tvTotalHarga.setText("-");
                tvDiskon.setText("-");
                tvJumlahBayar.setText("-");

                if (etJumlahBarang.getText().toString().length()==0){
                    etJumlahBarang.setError("Silahkan Isi Jumlah Barang");
                }

            }
        }

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etKodeBarang.setText(" ");
                etJumlahBarang.setText(" ");
                tvNamaBarang.setText("Nama Barang : ");
                tvHargaBarang.setText("Harga Barang : ");
                tvTotalHarga.setText("Total Harga : ");
                tvDiskon.setText("Diskon : ");
                tvJumlahBayar.setText("Jumlah Bayar : ");

                Toast.makeText(getApplicationContext(), "Data Telah Reset Ulang", Toast.LENGTH_LONG).show();
            }
        });

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
            }
        });

    }
}
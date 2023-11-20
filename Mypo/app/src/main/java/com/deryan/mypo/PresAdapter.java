package com.deryan.mypo;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class PresAdapter extends RecyclerView.Adapter<PresAdapter.PresidenViewHolder>{
    private List<PresClass> presiden = Arrays.asList(
            new PresClass("Soekarno", "1945-1967","Soekarno, nama lengkap Dr. Ir. Soekarno, adalah seorang pemimpin nasional Indonesia yang sangat berpengaruh dalam perjuangan kemerdekaan Indonesia dari penjajahan Belanda. Ia lahir pada tanggal 6 Juni 1901 dan meninggal pada tanggal 21 Juni 1970. Soekarno adalah presiden pertama Indonesia dan memainkan peran sentral dalam memproklamasikan kemerdekaan Indonesia pada 17 Agustus 1945. Ia dikenal dengan pidatonya yang karismatik dan visinya untuk Indonesia merdeka. Soekarno juga dikenal dengan semangat nasionalisnya yang kuat, serta konsep-konsep politik seperti \"Nasakom\" (nasionalisme, agama, komunisme) yang ia ajukan. Meskipun kontroversial dan berbagai dinamika politik selama masa pemerintahannya, Soekarno tetap menjadi ikon perjuangan kemerdekaan Indonesia dan seorang tokoh penting dalam sejarah negara ini.", R.drawable.soekarno),
            new PresClass("Soeharto", "1967-1998","Soeharto, lahir pada 8 Juni 1921 dan meninggal pada 27 Januari 2008, adalah seorang tokoh penting dalam sejarah Indonesia yang menjabat sebagai presiden dari tahun 1967 hingga 1998. Ia dikenal atas kepemimpinannya yang panjang dan otoriter. Masa pemerintahannya dicirikan oleh stabilitas politik dan pertumbuhan ekonomi yang signifikan, yang dikenal sebagai \"Orde Baru.\" Meskipun berhasil mencapai kemajuan ekonomi, pemerintahannya juga dicatat karena pelanggaran hak asasi manusia dan korupsi yang meluas. Soeharto mengundurkan diri pada tahun 1998 sebagai akibat dari tekanan massa dalam apa yang dikenal sebagai \"Reformasi\" dan \"Revolusi Mei,\" yang membawa perubahan signifikan dalam politik Indonesia pasca-Soeharto.", R.drawable.president_suharto__1993),
            new PresClass("BJ Habibie", "1998-1999","B.J. Habibie, nama lengkap Bacharuddin Jusuf Habibie, lahir pada 25 Juni 1936 dan meninggal pada 11 September 2019, adalah seorang tokoh penting dalam sejarah politik Indonesia. Ia adalah presiden ketiga Indonesia, menjabat dari tahun 1998 hingga 1999. Kepemimpinan Habibie ditandai oleh periode penting dalam sejarah Indonesia, termasuk krisis ekonomi dan Reformasi politik. Habibie dikenal karena kebijakan reformasi politiknya dan langkah-langkah menuju demokratisasi. Selama masa jabatannya, ia juga melakukan pembebasan tahanan politik dan mengadakan pemilu yang lebih bebas. Ia menjadi presiden setelah Soeharto mengundurkan diri dan membawa Indonesia menuju era reformasi politik yang penting dalam sejarah negara ini. Meskipun masa jabatannya singkat, peran Habibie dalam menginisiasi perubahan politik di Indonesia sangat penting dalam transisi negara ini menuju sistem demokrasi multi-partai.", R.drawable.b__j__habibie__president_of_indonesia_portrait),
            new PresClass("Abdurrahman Wahid", "1999-2001","Abdurrahman Wahid, yang lebih dikenal dengan sebutan Gus Dur, adalah seorang tokoh agama dan politik Indonesia yang lahir pada 7 September 1940 dan meninggal pada 30 Desember 2009. Ia adalah presiden keempat Indonesia yang menjabat dari tahun 1999 hingga 2001. Gus Dur adalah seorang ulama Muslim dan pemimpin Nahdlatul Ulama (NU), organisasi Islam terbesar di Indonesia. Selama masa pemerintahannya, Gus Dur memegang prinsip-prinsip pluralisme dan perdamaian antaragama. Ia mempromosikan dialog antaragama serta hak asasi manusia. Pemerintahannya juga dicirikan oleh gaya kepemimpinan yang santai dan aksesibel. Namun, masa pemerintahannya juga diwarnai oleh konflik politik dan ketegangan dengan beberapa elemen militer dan politik. Gus Dur dihormati sebagai tokoh yang mendorong toleransi agama dan pluralisme di Indonesia serta sebagai pendukung hak-hak asasi manusia. Setelah masa jabatannya sebagai presiden, ia terus terlibat dalam urusan politik dan agama di Indonesia hingga wafatnya pada tahun 2009.", R.drawable._50px_president_abdurrahman_wahid___indonesia),
            new PresClass("Megawati Soekarnoputri", "2001-2004","Megawati Soekarnoputri, lahir pada 23 Januari 1947, adalah seorang politikus Indonesia yang menjadi presiden kelima Indonesia dan presiden wanita pertama di negara tersebut. Megawati adalah putri dari Soekarno, pendiri Indonesia yang pertama, yang juga pernah menjabat sebagai presiden. Megawati menjabat sebagai presiden dari tahun 2001 hingga 2004. Selama masa pemerintahannya, ia mengambil berbagai langkah untuk meningkatkan stabilitas politik dan ekonomi Indonesia pasca-krisis finansial Asia. Ia juga dikenal karena pendekatannya yang lebih populis dalam politik. Meskipun masa jabatannya relatif singkat, Megawati merupakan figur penting dalam perkembangan demokrasi di Indonesia dan memberikan inspirasi bagi perempuan di negara ini untuk terlibat dalam politik. Setelah masa jabatannya sebagai presiden, ia terus berperan dalam dunia politik Indonesia dan memegang berbagai jabatan penting dalam pemerintahan dan partai politik.", R.drawable._50px_president_megawati_sukarnoputri___indonesia),
            new PresClass("Susilo Bambang Yudhoyono", "2004-2014","Susilo Bambang Yudhoyono, yang sering disebut dengan inisial \"SBY,\" adalah seorang politikus Indonesia yang lahir pada 9 September 1949. Ia adalah presiden keenam Indonesia yang menjabat dalam dua periode, yakni dari tahun 2004 hingga 2014. SBY adalah mantan perwira militer yang kemudian beralih ke politik sipil. Masa pemerintahan SBY dikenal karena upaya-upayanya dalam memperkuat demokrasi dan stabilitas politik di Indonesia. Ia berfokus pada program-program ekonomi dan reformasi yang bertujuan untuk meningkatkan pertumbuhan ekonomi dan mengurangi kemiskinan. Meskipun ada beberapa tantangan politik selama masa jabatannya, seperti masalah korupsi dan konflik regional, SBY dianggap sebagai salah satu pemimpin yang berhasil membawa stabilitas politik dan pertumbuhan ekonomi yang relatif stabil ke Indonesia selama dua periode kepemimpinannya. Setelah masa jabatannya sebagai presiden, SBY tetap aktif dalam politik dan memainkan peran penting dalam partai politiknya.", R.drawable.presiden_susilo_bambang_yudhoyono),
            new PresClass("Jokowi", "2014-2024","Joko Widodo, yang lebih dikenal dengan nama panggilan \"Jokowi,\" adalah seorang politikus Indonesia yang lahir pada 21 Juni 1961. Ia adalah presiden ketujuh Indonesia dan saat ini menjabat sebagai presiden pada saat pengetikan ini (2023). Jokowi adalah tokoh yang sangat populer di Indonesia dan memiliki latar belakang sebagai pengusaha sebelum terjun ke dunia politik. Sebelum menjadi presiden, Jokowi menjabat sebagai gubernur DKI Jakarta, salah satu jabatan politik terpenting di Indonesia. Ia dikenal karena gaya kepemimpinan yang sederhana, aksesibel, dan berfokus pada pembangunan infrastruktur, pertumbuhan ekonomi, dan peningkatan kesejahteraan rakyat. Salah satu inisiatif pentingnya adalah program \"Nawa Cita\" yang bertujuan meningkatkan kualitas hidup masyarakat Indonesia. Jokowi juga memprioritaskan reformasi birokrasi, investasi dalam sektor infrastruktur, dan peningkatan akses pendidikan dan kesehatan. Kepemimpinannya dalam menghadapi tantangan ekonomi global dan penanganan pandemi COVID-19 juga menjadi sorotan. Jokowi adalah salah satu tokoh paling berpengaruh di Indonesia dan memiliki dampak signifikan dalam pembangunan dan modernisasi negara ini.", R.drawable._50px_joko_widodo_2019_official_portrait)
    );
    public class PresidenViewHolder extends RecyclerView.ViewHolder{
        private TextView  nama,tahun,deskripsi;
        private ImageView gambar;
        private ConstraintLayout containerView;
        public  PresidenViewHolder(@NonNull View view){
            super(view);
            containerView = view.findViewById(R.id.baris);
            nama = view.findViewById(R.id.nama);
            tahun = view.findViewById(R.id.tahun);
            gambar = view.findViewById(R.id.gambar);
            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PresClass current = (PresClass) containerView.getTag();
                    Intent intent = new Intent(view.getContext(), DetailActivity.class);
                    intent.putExtra("nama",current.getName());
                    intent.putExtra("tahun",current.getTahun());
                    intent.putExtra("deskripsi",current.getDeskripsi());
                    intent.putExtra("gambar",current.getGambar());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
    @NonNull
    @Override
    public PresidenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.presiden_row,parent,false);
        return new PresidenViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PresidenViewHolder holder, int position) {
        PresClass current = presiden.get(position);
        holder.nama.setText(current.getName());
        holder.tahun.setText(current.getTahun());
        holder.gambar.setImageResource(current.getGambar());
        holder.containerView.setTag(current);
    }
    @Override
    public int getItemCount() {
        return presiden.size();
    }



}

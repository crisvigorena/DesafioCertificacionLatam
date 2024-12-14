package com.inforcap.desafiocertificacionlatam.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.inforcap.desafiocertificacionlatam.core.Constants
import com.inforcap.desafiocertificacionlatam.databinding.ActivityMainBinding
import com.inforcap.desafiocertificacionlatam.model.FigureDetailEntity
import com.inforcap.desafiocertificacionlatam.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapterMovie: AdapterMovie


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        initRecyclerView()

        binding.tvCategory.text = Constants.CATEGORY_ALLMOVIES
        viewModel.getAllFigures()

        viewModel.movieList.observe(this) {
            adapterMovie.movieList = it
            adapterMovie.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        val layoutManager = GridLayoutManager(this, 3)
        binding.rvMovies.layoutManager = layoutManager
        adapterMovie = AdapterMovie(this, arrayListOf()) { movieId ->
            Log.d("MainActivity", "Movie selected with ID: $movieId")
            fetchMovieDetails(movieId) // Llamada al método que interactúa con el microservicio
        }
        binding.rvMovies.adapter = adapterMovie
       // onItemSelected()

    }

    private fun fetchMovieDetails(movieId: Int) {


        // Aquí puedes interactuar con tu ViewModel o directamente con el microservicio
        viewModel.getDetail(movieId)

        // Observa el LiveData para obtener los datos cuando estén disponibles
        viewModel.figureDetail.observe(this) { detail ->
            if (detail != null) {
                Log.d("MainActivity", "Detail received: $detail")

                // Una vez que tienes los datos, puedes navegar a la nueva actividad
                navigateToDetailActivity(detail)
            } else {
                Log.e("MainActivity", "Failed to fetch details")
            }
        }

    }
    private fun navigateToDetailActivity(detail: FigureDetailEntity) {
        val intent = Intent(this, DetailsActivity::class.java).apply {


            putExtra("BUNDLE", Bundle().apply {
                if (detail != null) {
                    putParcelable("DETAIL",detail)
                }
            })

        }
        startActivity(intent)
    }

}
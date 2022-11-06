package com.applydigital.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.applydigital.core.result.State
import com.applydigital.domain.model.Hit
import com.applydigital.news.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private val newsViewModel: NewsViewModel by viewModels()
    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchNews()
        setRefresh()
        binding.swiperefresh.post {
            newsViewModel.fetchData()
        }
    }

    private fun fetchNews() {
        newsViewModel.fetchNews.observe(
            viewLifecycleOwner
        ) {
            binding.swiperefresh.isRefreshing = false
            when (it) {
                is State.Success -> {
                    setListNews(it.data!!.hits.sortedByDescending {
                        it.createdAt
                    })
                }
                is State.Error -> {
                    Toast.makeText(requireContext(),"could not update the news",Toast.LENGTH_SHORT).show()
                    setListNews(it.data!!.hits.sortedByDescending {
                        it.createdAt
                    })
                }
            }
        }
    }

    private fun setListNews(hits: List<Hit>) {
        binding.rvNews.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = NewsAdapter(ArrayList(hits), ::goToDetail, ::deleteNewsItem)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun deleteNewsItem(hit: Hit) {
        newsViewModel.deleteNewsItem(hit.parentId!!)
    }

    private fun goToDetail(hit: Hit) {
        if (hit.storyUrl.isNotEmpty()) {
            val action = NewsFragmentDirections.actionNewsFragmentToNewDetailFragment(
                hit.storyUrl
            )
            findNavController().navigate(action)
        } else {
            Toast.makeText(requireContext(), "URL NO ENCONTRADA", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setRefresh() {

        binding.swiperefresh.setOnRefreshListener {
            newsViewModel.fetchData()
        }
    }
}

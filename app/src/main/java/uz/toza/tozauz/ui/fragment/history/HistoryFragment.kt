package uz.toza.tozauz.ui.fragment.history

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.toza.tozauz.databinding.FragmentDashboardBinding
import uz.toza.tozauz.ui.adapter.HistoryAdapter
import uz.toza.tozauz.ui.dialog.DatePicter.DataPicterDialog
import uz.toza.tozauz.utils.date.dateConvert

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val historyViewModel: HistoryViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            dateConvert {
            }
            dateConvert {
                historyViewModel.getHistory(it,it)
                txtToDay.text = it
                txtFromDay.text = it
            }
            loader.visibility = View.VISIBLE

            btnLeft.setOnClickListener {
                showDialog(1)
            }

            btnRight.setOnClickListener {
                showDialog(2)
            }
            recyclerview.layoutManager = LinearLayoutManager(requireContext())
            historyViewModel.getOrderHistory.observe(requireActivity()) {
                recyclerview.adapter = HistoryAdapter(it.list)
                txtOne.text = it.type1.toString()
                txtTwo.text = it.type2.toString()
                binding.loader.visibility = View.GONE
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showDialog(type: Int) {
        val dialog = DataPicterDialog(requireContext(), type = type.toString()) {
            binding.apply {
                if (type == 1) {
                    txtFromDay.text = it
                } else {
                    txtToDay.text = it
                }
                loader.visibility = View.VISIBLE
                historyViewModel.getHistory(txtFromDay.text.toString(), txtToDay.text.toString())

            }
        }
        dialog.show()
    }

}
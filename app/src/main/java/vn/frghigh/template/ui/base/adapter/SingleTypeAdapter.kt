/*
 * Copyright (C) 2016 MarkZhai (http://zhaiyifan.cn).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vn.frghigh.template.ui.base.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.ViewGroup

import java.util.ArrayList

/**
 * Super simple single-type adapter using data-binding.
 *
 * @author markzhai on 16/8/22
 */
class SingleTypeAdapter<T> @JvmOverloads constructor(context: Context, @get:LayoutRes
protected var layoutRes: Int = 0) : BaseViewAdapter<T>(context) {

    interface Listener<T> : BaseViewAdapter.Listener {
        fun onItemClick(t: T)
    }

    init {
        mCollection = ArrayList<T>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        return BindingViewHolder(
                DataBindingUtil.inflate<ViewDataBinding>(mLayoutInflater, layoutRes, parent, false))
    }

    override fun getItemCount(): Int {
        return mCollection!!.size
    }

    fun add(viewModel: T) {
        mCollection!!.add(viewModel)
        notifyDataSetChanged()
    }

    fun add(position: Int, viewModel: T) {
        mCollection!!.add(position, viewModel)
        notifyDataSetChanged()
    }

    fun set(viewModels: List<T>) {
        mCollection!!.clear()
        addAll(viewModels)
    }

    fun addAll(viewModels: List<T>) {
        mCollection!!.addAll(viewModels)
        notifyDataSetChanged()
    }
}
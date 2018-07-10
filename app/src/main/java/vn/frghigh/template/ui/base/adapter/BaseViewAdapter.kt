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
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import vn.frghigh.template.BR

/**
 * Base Data Binding RecyclerView Adapter.
 *
 * @author markzhai on 16/8/25
 */
abstract class BaseViewAdapter<T>(context: Context) : RecyclerView.Adapter<BindingViewHolder<*>>() {

    protected val mLayoutInflater: LayoutInflater

    protected var mCollection: MutableList<T>? = null
    protected var listener: Listener? = null
    protected var mDecorator: Decorator? = null

    interface Listener

    interface Decorator {
        fun decorator(holder: BindingViewHolder<*>, position: Int, viewType: Int)
    }

    init {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        val item = mCollection!![position]
        holder.binding.setVariable(BR.item, item)
        holder.binding.setVariable(BR.listener, listener)
        holder.binding.executePendingBindings()
        if (mDecorator != null) {
            mDecorator!!.decorator(holder, position, getItemViewType(position))
        }
    }

    override fun getItemCount(): Int {
        return mCollection!!.size
    }

    open fun remove(position: Int) {
        mCollection!!.removeAt(position)
        notifyItemRemoved(position)
    }

    open fun clear() {
        mCollection!!.clear()
        notifyDataSetChanged()
    }

    fun setDecorator(decorator: Decorator) {
        mDecorator = decorator
    }

}

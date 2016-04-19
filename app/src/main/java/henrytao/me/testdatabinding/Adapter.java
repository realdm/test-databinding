/*
 * Copyright 2016 "Henry Tao <hi@henrytao.me>"
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

package henrytao.me.testdatabinding;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import henrytao.me.testdatabinding.databinding.ItemViewHolderBinding;

/**
 * Created by henrytao on 4/19/16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<Integer> mData;

    public Adapter(@NonNull List<Integer> data) {
        mData = data;
    }

    public void replaceData(List<Integer> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_view_holder, parent, false));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemViewHolderBinding mBinding;

        private final ItemViewModel mViewModel;

        public ViewHolder(ItemViewHolderBinding binding) {
            super(binding.getRoot());
            mBinding = binding;

            mViewModel = new ItemViewModel();
            mBinding.setViewModel(mViewModel);
        }

        public void bind(int data) {
            mViewModel.setData(data);
        }
    }
}

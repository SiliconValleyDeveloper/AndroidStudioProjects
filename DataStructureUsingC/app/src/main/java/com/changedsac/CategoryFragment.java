package com.changedsac;

import android.app.ProgressDialog;


import com.changedsac.Common.Common;
import com.changedsac.Interface.ItemClickListener;
import com.changedsac.Model.Category;
import com.changedsac.ViewHolder.CategoryViewHolder;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;




public class CategoryFragment extends Fragment{

    RecyclerView listCategory;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Category, CategoryViewHolder> adapter;
    FirebaseDatabase database;
    DatabaseReference categories;
    View myFragment;


    public static CategoryFragment newInstance() {
        CategoryFragment categoryFragment = new CategoryFragment();
        return categoryFragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        categories = database.getReference("Category");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_category, container, false);


        listCategory = (RecyclerView) myFragment.findViewById(R.id.listCategory);
        listCategory.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listCategory.setLayoutManager(layoutManager);
        loadCategories();

        return myFragment;
    }


    private void loadCategories() {

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading..");
        progressDialog.show();

        adapter = new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(

                Category.class,
                R.layout.category_layout,
                CategoryViewHolder.class,
                categories
        ) {

            @Override
            protected void populateViewHolder(CategoryViewHolder viewHolder, final Category model, int position) {
                progressDialog.dismiss();

              viewHolder.category_name.setText(model.getName());

                Picasso.with(getActivity())
                        .load(model.getImage())

                        .into(viewHolder.category_image);
                viewHolder.category_total.setText(model.getTotal());
                viewHolder.setItemClickListener(
                        new ItemClickListener() {
                            @Override
                            public void onClick(View view, int position, boolean isLongClick) {
                               // Toast.makeText(getActivity(),String.format("%s|%s|%s",adapter.getRef(position).getKey(),model.getName(),model.getTotal()),Toast.LENGTH_SHORT).show();
                                Intent start_online = new Intent(getActivity(), Start_Online.class);
                                Common.categoryId = adapter.getRef(position).getKey();
                               Common.categoryName = model.getName();
                                startActivity(start_online);

                            }
                        });


            }


        };

        adapter.notifyDataSetChanged();
        listCategory.setAdapter(adapter);


    }






}

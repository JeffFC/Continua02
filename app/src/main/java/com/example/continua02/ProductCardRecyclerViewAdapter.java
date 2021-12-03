package com.example.continua02;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.continua02.network.ImageRequester;
import com.example.continua02.network.ProductEntry;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

    public class ProductCardRecyclerViewAdapter extends RecyclerView.Adapter<ProductCardViewHolder> {
    private List<ProductEntry> productList;
    private ImageRequester imageRequester;


    ProductCardRecyclerViewAdapter(List<ProductEntry> productList) {
        this.productList = productList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);
        return new ProductCardViewHolder(layoutView);
    }

        @Override
        public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position) {
            if (productList != null && position < productList.size()) {
                ProductEntry product = productList.get(position);
                holder.productTitle.setText(product.title);
                imageRequester.setImageFromUrl(holder.productImage, product.url);
            }
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }

}

package com.example.taskapp.ui.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.R;
import com.example.taskapp.databinding.FragmentOnBoardBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    private Button button;
    private FragmentOnBoardBinding binding;
    private String[] list = {"FACEBOOK","INSTAGRAM", "WHATSAPP"};
    private int[] list1 ={R.drawable.fb2,R.drawable.inst,R.drawable.w};
    @NonNull
    @Override
    public BoardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pager_board,
               parent,
               false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardAdapter.ViewHolder holder, int position) {
        holder.onBind(position);

        }


    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title, description;
        private Button openButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.boardIv);
            title = itemView.findViewById(R.id.boardTv);
            description = itemView.findViewById(R.id.boardTv2);
            openButton = itemView.findViewById(R.id.openBtn);
        }

        public void onBind(int position) {
switch (position){
    case 0:
        openButton.setVisibility(View.GONE);
        break;
    case 1:
        openButton.setVisibility(View.GONE);
        break;
    case 2:
        openButton.setVisibility(View.VISIBLE);
        break;
}
            title.setText(list[position]);
            imageView.setImageResource(list1[position]);

}


        }
}



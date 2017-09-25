package at.schneider_holding.chat;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import at.schneider_holding.base.BaseController;

public class ChatController extends BaseController {
  @Override public boolean canGoBack() {
    return true;
  }

  @NonNull @Override protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
    return inflater.inflate(R.layout.layout_chat, container, false);
  }
}

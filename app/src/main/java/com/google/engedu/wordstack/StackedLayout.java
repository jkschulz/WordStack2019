/* Copyright 2016 Google Inc.
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

package com.google.engedu.wordstack;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Stack;

public class StackedLayout extends LinearLayout {

  private Stack<View> tiles = new Stack();

  public StackedLayout(Context context) {
    super(context);
  }

  public void push(View tile) {
    // call removeView with the tile on top of the stack (if there is one) to hide that tile
    if (!tiles.empty()) {
      removeView(tiles.peek());
    }

    // push the specified tile onto the tiles stack
    tiles.push(tile);
    // call addView with the tile that was just pushed
    addView(tiles.peek());

  }

  public View pop() {
    View popped = null;

    if (!tiles.empty()) {
      // Pop a view from the tiles and remove it from the screen.
      popped = tiles.pop();
      removeView(popped);
      // If there are any letters left in the stack, show the next one.
      if (!tiles.empty()) {
        addView(tiles.peek());
      }
    }

    // Return the popped tile (or null if the stack is empty).
    return popped;
  }

  public View peek() {
    return tiles.peek();
  }

  public boolean empty() {
    return tiles.empty();
  }

  public void clear() {
    /**
     **
     **  YOUR CODE GOES HERE
     **
     **/
  }
}

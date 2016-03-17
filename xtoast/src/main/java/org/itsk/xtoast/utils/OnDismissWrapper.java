/**
 *  Copyright 2014 John Persano
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *
 */

package org.itsk.xtoast.utils;

import android.view.View;
import org.itsk.xtoast.XToast;

/**
 *  Class that holds a reference to OnDismissListeners set to button type SuperActivityToasts/SuperCardToasts.
 *  This is used for restoring listeners on orientation changes.
 */
public class OnDismissWrapper implements XToast.OnDismissListener {

    private final String mTag;
    private final XToast.OnDismissListener mOnDismissListener;

    /**
     *  Creates an OnClickWrapper.
     *
     *  @param tag {@link CharSequence} Must be unique to this listener
     *  @param onDismissListener {@link XToast.OnDismissListener}
     */
    public OnDismissWrapper(String tag, XToast.OnDismissListener onDismissListener) {

        this.mTag = tag;
        this.mOnDismissListener = onDismissListener;

    }

    /**
     *  Returns the tag associated with this OnDismissWrapper. This is used to
     *  reattach {@link XToast.OnDismissListener}s.
     *
     *  @return {@link String}
     */
    public String getTag() {

        return mTag;

    }

    @Override
    public void onDismiss(View view) {

        mOnDismissListener.onDismiss(view);

    }

}
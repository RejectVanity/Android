/*
 * Copyright (c) 2024 DuckDuckGo
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

package com.duckduckgo.app.statistics.api

import com.duckduckgo.app.statistics.pixels.Pixel.PixelType
import io.reactivex.Completable
import io.reactivex.Single

interface PixelSender {
    fun sendPixel(
        pixelName: String,
        parameters: Map<String, String>,
        encodedParameters: Map<String, String>,
        type: PixelType,
    ): Single<SendPixelResult>

    fun enqueuePixel(
        pixelName: String,
        parameters: Map<String, String>,
        encodedParameters: Map<String, String>,
    ): Completable

    enum class SendPixelResult {
        PIXEL_SENT,
        PIXEL_IGNORED, // Daily or unique pixels may be ignored.
    }
}

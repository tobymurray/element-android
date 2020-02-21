/*
 * Copyright 2016 OpenMarket Ltd
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

package im.vector.matrix.android.internal.crypto

import im.vector.matrix.android.api.session.events.model.Event
import im.vector.matrix.android.api.session.events.model.toModel
import im.vector.matrix.android.internal.crypto.model.rest.RoomKeyShareCancellation

/**
 * IncomingRoomKeyRequestCancellation describes the incoming room key cancellation.
 */
data class IncomingRoomKeyRequestCancellation(
        /**
         * The user id
         */
        override val userId: String? = null,

        /**
         * The device id
         */
        override val deviceId: String? = null,

        /**
         * The request id
         */
        override val requestId: String? = null
) : IncomingRoomKeyRequestCommon {
    companion object {

        /**
         * Factory
         *
         * @param event the event
         */
        fun fromEvent(event: Event): IncomingRoomKeyRequestCancellation {
            val roomKeyShareRequestCancellation = event.getClearContent().toModel<RoomKeyShareCancellation>()!!

            return IncomingRoomKeyRequestCancellation(
                    userId = event.senderId,
                    deviceId = roomKeyShareRequestCancellation.requestingDeviceId,
                    requestId = roomKeyShareRequestCancellation.requestId
            )
        }
    }
}

/**
 * Copyright 2011-2015 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.http.action.async.sse

import io.gatling.http.action.async.{ UserAction, AsyncTx }

import io.gatling.http.check.async.AsyncCheck

sealed trait SseEvent
case class OnOpen(tx: AsyncTx, sseStream: SseStream, time: Long) extends SseEvent
case class OnFailedOpen(tx: AsyncTx, errorMessage: String, time: Long) extends SseEvent
case class OnMessage(message: String, time: Long) extends SseEvent
case class OnThrowable(tx: AsyncTx, errorMessage: String, time: Long) extends SseEvent
case object OnClose extends SseEvent
case class CheckTimeout(check: AsyncCheck) extends SseEvent

trait SseUserAction extends UserAction with SseEvent

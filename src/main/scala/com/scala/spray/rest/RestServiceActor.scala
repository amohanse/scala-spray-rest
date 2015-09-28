package com.scala.spray.rest

import akka.actor.{ActorLogging, Actor}
import akka.actor.ActorLogging
import spray.http.MediaTypes
import spray.httpx.SprayJsonSupport
import spray.json.DefaultJsonProtocol
import spray.json.DefaultJsonProtocol._
import spray.httpx.SprayJsonSupport._
import spray.routing._

/**
 * Created by mohananandan on 25/09/15.
 */

object UserProtocol extends DefaultJsonProtocol {

  case class User(name: String)

  implicit val UserFormat = jsonFormat1(User)

}

import UserProtocol._

class RestServiceActor extends Actor with HttpService with ActorLogging with SprayJsonSupport {

  def actorRefFactory = context

  def receive = runRoute(apiRoute)

  val apiRoute: Route =
    path("user") {
      import UserProtocol._
      get {
        log.info("Building Get Request")
        complete {
          log.info("Executing log route")
          List(User("User1"), User("User2"))
        }
      }
    } ~ path("") {
        respondWithMediaType(MediaTypes.`text/html`) {
        complete {
          <html>
            <body>
              <a href="/user">The list of users</a>
            </body>
          </html>
        }
      }
    }
}

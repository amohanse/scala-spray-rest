package com.scala.spray.rest

import akka.actor.{Props, ActorSystem}
import akka.util.Timeout
import spray.can.Http
import akka.io.IO
import akka.pattern.ask
import scala.concurrent.duration._

/**
 * Created by mohananandan on 25/09/15.
 */
object Boot extends App {

  implicit val system = ActorSystem("scalasprayrest")

  val service = system.actorOf(Props[RestServiceActor],"rest-service")

  implicit val timeOut = Timeout(5.seconds)

  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)

}

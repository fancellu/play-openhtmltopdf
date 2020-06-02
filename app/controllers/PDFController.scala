package controllers

import akka.stream.scaladsl.Source
import javax.inject._
import play.api.mvc._
import util.PDFUtil

import scala.concurrent.Future

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class PDFController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def pdf = Action.async { implicit request =>
    val html = views.html.pdf1()

    Future.successful(Ok.chunked(Source.single(PDFUtil.toByteArray(html, PDFUtil.getBaseUrl))).as("application/pdf").withHeaders(
      CONTENT_DISPOSITION -> ("attachment; filename=" + "xxx.pdf")
    ))
  }

  def index = Action.async { implicit request =>
    val html = views.html.pdf1()

    Future.successful(Ok(html))
  }

}

package util

import java.io.ByteArrayOutputStream
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder
import com.openhtmltopdf.svgsupport.BatikSVGDrawer
import play.api.mvc.{ AnyContent, Call, Request }
import play.twirl.api.Html

object PDFUtil {

  def getBaseUrl(implicit request: Request[AnyContent]): String = {
    new Call(request.method, request.uri).absoluteURL()
  }

  def toByteArray(html: Html, baseUri: String): Array[Byte] = {
    val builder = new PdfRendererBuilder

    builder.withHtmlContent(html.toString, baseUri)

    val bos = new ByteArrayOutputStream(4096)
    builder.toStream(bos)
    //builder.useFastMode()

    builder.useSVGDrawer(new BatikSVGDrawer)

    builder.run

    bos.toByteArray
  }
}

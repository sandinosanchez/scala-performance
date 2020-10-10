import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.core.structure.ScenarioBuilder

class BasicSimulation extends Simulation {

  val httProtocol: HttpProtocolBuilder = http
    .baseUrl("http://computer-database.gatling.io")

  val scn : ScenarioBuilder = scenario("BasicSimulation")
    .exec(http("request_1")
      .get("/"))
    .pause(5)

  setUp(scn.inject(atOnceUsers(1))).protocols(httProtocol)
}

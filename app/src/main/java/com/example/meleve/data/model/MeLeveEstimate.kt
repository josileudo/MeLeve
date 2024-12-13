import kotlinx.serialization.Serializable

@Serializable
data class MeLeveEstimate(
    val origin: Location,
    val destination: Location,
    val distance: Int,
    val duration: Int,
    val options: List<MeLeveOption>,
    val routeResponse: RouteResponse
)

@Serializable
data class Location(
    val latitude: Double,
    val longitude: Double
)

@Serializable
data class MeLeveOption(
    val id: Int,
    val name: String,
    val description: String,
    val vehicle: String,
    val review: MeLeveReview,
    val value: Double
)

@Serializable
data class MeLeveReview(
    val rating: Int,
    val comment: String
)

@Serializable
data class RouteResponse(
    val routes: List<Route>,
    val geocodingResults: GeocodingResults? = null
)

@Serializable
data class Route(
    val legs: List<Leg>,
    val distanceMeters: Int,
    val duration: String,
    val staticDuration: String,
    val polyline: Polyline,
    val description: String? = null,
    val warnings: List<String>? = null,
    val viewport: Viewport? = null,
    val travelAdvisory: TravelAdvisory? ,
    val localizedValues: LocalizedValues? = null,
    val routeLabels: List<String>? = null,
    val polylineDetails: PolylineDetails?
)

@Serializable
data class Leg(
    val distanceMeters: Int,
    val duration: String,
    val staticDuration: String,
    val polyline: Polyline,
    val startLocation: LocationWrapper,
    val endLocation: LocationWrapper,
    val steps: List<Step>,
    val localizedValues: LocalizedValues? = null
)

@Serializable
data class Step(
    val distanceMeters: Int,
    val staticDuration: String,
    val polyline: Polyline,
    val startLocation: LocationWrapper,
    val endLocation: LocationWrapper,
    val navigationInstruction: NavigationInstruction,
    val localizedValues: LocalizedValues? = null,
    val travelMode: String
)

@Serializable
data class NavigationInstruction(
    val maneuver: String,
    val instructions: String
)

@Serializable
data class LocalizedValues(
    val distance: LocalizedValue? = null,
    val duration: LocalizedValue? = null,
    val staticDuration: LocalizedValue? = null
)

@Serializable
data class LocalizedValue(
    val text: String
)

@Serializable
data class Polyline(
    val encodedPolyline: String
)

@Serializable
data class LocationWrapper(
    val latLng: Location
)

@Serializable
data class Viewport(
    val low: Location,
    val high: Location
)

@Serializable
data class TravelAdvisory(
    val type: String? = null ,
    val description: String? = null
)

@Serializable
data class PolylineDetails(
    val startLocation: Location? = null,
    val endLocation: Location? = null
)

@Serializable
data class GeocodingResults(
    val origin: GeocodeResult? = null,
    val destination: GeocodeResult? = null
)

@Serializable
data class GeocodeResult(
    val geocoderStatus: Map<String, String>? = null,
    val type: List<String>? = null,
    val placeId: String? = null
)
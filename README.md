# Haversine-Formula


Haversine Formula (shown below) expressed in terms of a two-argument inverse tangent function to calculate the great circle distance between two points on the Earth

#######################################################################################
dlon = lon2 - lon1 ,
dlat = lat2 - lat1 ,
a = (sin(dlat/2))^2 + cos(lat1) * cos(lat2) * (sin(dlon/2))^2 ,
c = 2 * atan2( sqrt(a), sqrt(1-a) ) ,
d = R * c (where R is the radius of the Earth)
##########################################################################################
--------------------------------use---------------------------------------------

model.compile(optimizer=optimizer, loss=[Haversine(R)])

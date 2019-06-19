import tensorflow as tf
from keras import backend as K

'''Compatible with tensorflow backend'''


def Haversine(R)  # (where R is the radius of the Earth)
  def loss_function(y_true,y_pred):  # y[Longitude,Latitude] change it accordingly
    dlon=y_true[:,0]-y_pred[:,0]
    dlat=y_true[:,1]-y_pred[:,1]
    a=K.square(K.sin(dlat/2))+K.cos(y_true[1])*K.cos(y_pred[1])*K.square(K.sin(dlon)/2)
    c=2*(tf.atan2(K.sqrt(a),K.sqrt(1-a)))
    return K.abs(c*R)
  return loss_function


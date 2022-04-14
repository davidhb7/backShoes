from django.db import models

# Create your models here.
class producto( models.Model):
    nombre = models.CharField(max_length=70)
    descripcion = models.CharField(max_length=200)
    precio = models.DecimalField(max_digits=15, decimal_places=2)
    disponible = models.BooleanField(default=False)
    fecha_creacion = models.DateTimeField(blank=True, auto_now=True, null = True)
    #fecha_modificacion = models.DateTimeField(blank=True, auto_now_add=True, null = True)
    #calificacion =  models.DecimalField(max_digits=2, decimal_places= 1, blank=True, null=True, default=5)
    imagen_64 = models.TextField(null = True, default= '')
    

    def __str__(self):
        return self.nombre


    class Meta:
        db_table = 'producto'
        verbose_name = "producto"
        verbose_name_plural='productos'

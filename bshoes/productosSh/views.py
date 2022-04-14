from django.shortcuts import render
from rest_framework import viewsets
from .models import *
from .serializers import *


# Create your views here.
class ProductoController(viewsets.ModelViewSet):
    queryset = producto.objects.all().order_by('id')
    serializer_class = ProductoSerializer

# Generated by Django 4.0.3 on 2022-04-04 02:56

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('productosSh', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='producto',
            name='imagen_64',
            field=models.TextField(default='https://seedpaybuck.s3.sa-east-1.amazonaws.com/usuarios/71276688-7770-4a41-a7a2-24bd867043a1.jpg', null=True),
        ),
    ]

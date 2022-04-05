import requests
from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.

def ShowHomePage(request):
    if(request.method=='POST'):
        city = request.POST['city']
    
        url = 'http://api.openweathermap.org/'
        
        #city = 'Mumbai'
        r = requests.get(url.format(city)).json()

        city_weather = {
            'city' : city,
            'lon' : r['coord']['lon'],
            'lat' : r['coord']['lat'],
            'temperature' : r['main']['temp'],
            'humidity' : r['main']['humidity'],
            'description' : r['weather'][0]['description'],
            'wind' : r['wind']['speed'],
            'country' : r['sys']['country'],

            
        }
    

        context = {'city_weather' : city_weather }

    else:
        context = {}

    return render(request, 'home.html', context)

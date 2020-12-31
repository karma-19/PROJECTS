from django.shortcuts import render
from django.views.generic import ListView, DetailView
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from django.urls import reverse_lazy
from .models import post
# Create your views here.
class BlogListView(ListView): #see post in list manner
  model = post
  template_name = 'home.html'

class BlogDetailView(DetailView): #see post in detail
  model = post
  template_name = 'post_detail.html'

class BlogCreateView(CreateView): #add new posts
  model = post
  template_name = 'post_new.html'
  fields = ['title', 'author', 'body']

class BlogUpdateView(UpdateView):
  model = post
  template_name = 'post_edit.html'
  fields = ['title', 'body']

class BlogDeleteView(DeleteView):
  model = post
  template_name = 'post_delete.html'
  success_url = reverse_lazy('home')

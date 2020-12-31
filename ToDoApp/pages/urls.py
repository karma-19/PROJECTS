from django.urls import path
from .views import (
  TodoListView, 
  TodoCreateView,
  TodoDeleteView,
)

urlpatterns = [
  path('<int:pk>/delete', TodoDeleteView.as_view(), name='delete_task'),
  path('new_task/', TodoCreateView.as_view(), name='new_task'),
  path('', TodoListView.as_view(), name ='home'),
]
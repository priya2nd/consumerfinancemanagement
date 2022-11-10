import React from 'react';
import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/UserLogin';
import Form from './pages/RegisterUser';
import UserList from './components/Navbar/UserList';
import CardDashboard from './pages/CardDashboard';
import ProductList from './pages/ProductList';
import Adminlogin from './pages/AdminLogin'
import AdminDashboard from './pages/AdminDashboard'
import ForgotPassword from './pages/ForgotPassword';

function App() {
return (
  
	<Router>
	<Navbar />
  	<UserList />
	<Routes>
		<Route index path='/' exact element={<Home />} />
		<Route path='/index' exact element={<Home />} />
		<Route path='/login' element={<Login />} />
		<Route path='/sign-up' element={<Form />} />
		<Route path='/users' element={<UserList />} />
		<Route path='/card-dashboard' element={<CardDashboard />} />
		<Route path='/product-list' element={<ProductList />} />

		<Route path='/admin-dashboard' element={<AdminDashboard />} />
		<Route path='/login/adminlogin' element={<Adminlogin />} />
		<Route path='/login/forgotpassword' element={<ForgotPassword />} />
	</Routes>
	</Router>
);
}

export default App;

import React from 'react';
import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/UserLogin';
import Form from './pages/RegisterUser';
import UserList from './components/Navbar/UserList';
import Products from './pages/productlist-1st';
import CardDashboard from './pages/CardDashboard';
import ProductList from './pages/ProductList';

function App() {
return (
  
	<Router>
	<Navbar />
  	{/* <UserList /> */}
	<Routes>
		<Route path='/' exact element={<Home />} />
		<Route path='/index' exact element={<Home />} />
		<Route path='/login' element={<Login />} />
		<Route path='/sign-up' element={<Form />} />
		<Route path='/users' element={<UserList />} />
		<Route path='/card-dashboard' element={<CardDashboard />} />
		<Route path='/product-list' element={<ProductList />} />


		{/* //check// */}
		<Route path='/product-list-1' element={<Products />} />
	</Routes>
	</Router>
);
}

export default App;

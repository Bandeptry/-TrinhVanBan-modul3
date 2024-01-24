package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepostoryImp implements IProductRepository{
    protected static List<Product> products;
    static {
        products = new ArrayList<>();
        products.add(new Product(1,"Laptop Dell XPS","Laptop mỏng nhẹ, hiệu suất cao",1500,50));
        products.add(new Product(2,"Smartphone Samsung","Điện thoại di động với camera ấn tượng",800,100));
        products.add(new Product(3,"Tivi Sony 4K ","Tivi LED 4K với âm thanh mạnh mẽ.",1200,30));
        products.add(new Product(4,"Máy ảnh Canon ","Máy ảnh DSLR chuyên nghiệp.",1000 ,40));
        products.add(new Product(5,"Tai nghe Sony ","Tai nghe không dây chất lượng cao",200,200));
    }

    @Override
    public List<Product> display() {
        return products;
    }

    @Override
    public void updata(int id,Product newProduct) {
        products.set(id,newProduct);
    }

    @Override
    public void create(Product newProduct) {
        products.add(newProduct);
    }

    @Override
    public void delete(int byID) {
        products.remove(byID);
    }


    @Override
    public List<Product> seachProduct(String nameProduct) {
        return products;
    }

    @Override
    public List<Product> seenDetails() {
        return products;
    }
}

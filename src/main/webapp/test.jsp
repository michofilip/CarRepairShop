<form action="/vehicle-add" method="post">
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Model</label>
        <input type="text" class="form-control" placeholder="Model" name="model" required>
        </label>

    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Brand</label>
        <input type="text" class="form-control" placeholder="Brand" name="brand" required>
        </label>
    </div>

    <div class="form-group" style="margin-left: auto;margin-right: auto;" >
        <label>Production</label>
        <input  class="form-control" placeholder="Year" type="text" name="year">
        </label>

    </div>

    <div class="form-group" style="margin-left: auto;margin-right: auto;" >
        <label>Next checkup</label>
        <input  class="form-control" placeholder="Checkup date" type="text" name="checkup">
        </label>

    </div>



    <div class="form-group" style="margin-left: auto;margin-right: auto;" >
        <label>Next checkup</label>
        <input  class="form-control" placeholder="Checkup date" type="date" name="checkup">
        </label>

    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;" >
        <label>Owner id</label>
        <input  class="form-control" placeholder="Id" type="text" name="id">
        </label>

    </div>

    <button type="submit" class="btn btn-default" value="submit">Wyslij</button>


</form>